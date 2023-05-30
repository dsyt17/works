using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MetroFramework.Forms;
using System.Diagnostics;
using System.Management;
using Microsoft.VisualBasic;



namespace SystemInfo
{
    public partial class Form3 : MetroForm
    {

        private List<Process> processes = null;

        private ListComparer comparer = null;
        public Form3()
        {
            InitializeComponent();
        }

        private void GetProcesses()
        {
            processes.Clear();

            processes = Process.GetProcesses().ToList<Process>();

        }

        
        private void RefreshList()
        {
            listView1.Items.Clear();

            double memSize = 0;
            
            foreach (Process p in processes)
            {
                memSize = 0;

                PerformanceCounter pc = new PerformanceCounter();
                pc.CategoryName = "Process";
                pc.CounterName = "Working Set - Private";
                pc.InstanceName = p.ProcessName;

                memSize = (double)pc.NextValue() / (1000 * 1000);

                string[] row = new string[] { p.ProcessName.ToString(), Math.Round(memSize, 1).ToString() };

                listView1.Items.Add(new ListViewItem(row));

                pc.Close();
                pc.Dispose();

            }

            Text = "Запущенно процессов: " + processes.Count.ToString();

        }

        private void RefreshList(List<Process> processes, string keyword)
        {

            try
            {

                listView1.Items.Clear();

                double memSize = 0;

                foreach (Process p in processes)
                {
                    if (p != null)
                    {
                        memSize = 0;

                        PerformanceCounter pc = new PerformanceCounter();
                        pc.CategoryName = "Process";
                        pc.CounterName = "Working Set - Private";
                        pc.InstanceName = p.ProcessName;

                        memSize = (double)pc.NextValue() / (1000 * 1000);

                        string[] row = new string[] { p.ProcessName.ToString(), Math.Round(memSize, 1).ToString() };

                        listView1.Items.Add(new ListViewItem(row));

                        pc.Close();
                        pc.Dispose();
                    }

                }

                Text = $"Запущенно процессов '{keyword}': " + processes.Count.ToString();
            }
            catch (Exception) { }

        }

        private void killProcess(Process process)
        {
            process.Kill();

            process.WaitForExit();

        }

        private void killProcessAnd(int pid)
        {
            if (pid == 0)
            {
                return;
            }

            ManagementObjectSearcher searcher = new ManagementObjectSearcher("Select * from Win32_Process where ParentProcessID=" + pid);
            ManagementObjectCollection objectCollection = searcher.Get();

            foreach (ManagementObject obj in objectCollection)
            {
                killProcessAnd(Convert.ToInt32(obj["ProcessID"]));

                try
                {
                    Process p = Process.GetProcessById(pid);

                    p.Kill();
                    p.WaitForExit();

                }

                catch (ArgumentException) { }

            }


        }

        private int GetParentId(Process p)
        {

            int parentID = 0;

            try
            {

                ManagementObject managementObject = new ManagementObject("win32_process.handle='" + p.Id + "'");

                managementObject.Get();

                parentID = Convert.ToInt32(managementObject["ParentProcessID"]);

            }

            catch (Exception) { }

            return parentID;

        }


        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            GetProcesses();

            RefreshList();
        }

        private void contextMenuStrip1_Opening(object sender, CancelEventArgs e)
        {

        }

        private void Form3_Load(object sender, EventArgs e)
        {
            processes = new List<Process>();

            GetProcesses();

            RefreshList();

            comparer = new ListComparer();
            comparer.ColumnIndex = 0;

        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            try
            {
                if (listView1.SelectedItems[0] != null)
                {
                    Process processTokill = processes.Where((x) => x.ProcessName == listView1.SelectedItems[0].SubItems[0].Text).ToList()[0];

                    killProcess(processTokill);

                    GetProcesses();

                    RefreshList();

                }

            }

            catch (Exception) { }

        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            try
            {
                if (listView1.SelectedItems[0] != null)
                {
                    Process processTokill = processes.Where((x) => x.ProcessName == listView1.SelectedItems[0].SubItems[0].Text).ToList()[0];

                    killProcessAnd(GetParentId(processTokill));

                    GetProcesses();

                    RefreshList();

                }

            }

            catch (Exception) { }

        }

        private void завершитьДеревоПроцессовToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (listView1.SelectedItems[0] != null)
                {
                    Process processTokill = processes.Where((x) => x.ProcessName == listView1.SelectedItems[0].SubItems[0].Text).ToList()[0];

                    killProcessAnd(GetParentId(processTokill));

                    GetProcesses();

                    RefreshList();

                }

            }

            catch (Exception) { }

        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            string path = Interaction.InputBox("Имя программы", "Запуск задачи");

            try
            {
                Process.Start(path);
            }

            catch (Exception) { }
        }

        private void toolStripTextBox1_TextChanged(object sender, EventArgs e)
        {
            GetProcesses();

            List<Process> filtered = processes.Where((x) => 
            x.ProcessName.ToLower().Contains(toolStripTextBox1.Text.ToLower())).ToList<Process>();

            RefreshList(filtered, toolStripTextBox1.Text);
        }

        private void завершитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (listView1.SelectedItems[0] != null)
                {
                    Process processTokill = processes.Where((x) => x.ProcessName == listView1.SelectedItems[0].SubItems[0].Text).ToList()[0];

                    killProcess(processTokill);

                    GetProcesses();

                    RefreshList();

                }

            }

            catch (Exception) { }
        }

        private void listView1_ColumnClick(object sender, ColumnClickEventArgs e)
        {
            comparer.ColumnIndex = e.Column;

            comparer.SortDirection = comparer.SortDirection == SortOrder.Ascending ? SortOrder.Descending : SortOrder.Ascending;

            listView1.ListViewItemSorter = comparer;

            listView1.Sort();
        }
    }
}
