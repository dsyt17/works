using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Management;
using MetroFramework.Forms;



namespace SystemInfo
{
    public partial class Form1 : MetroForm
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void GetInfo(string key, ListView list)
        {
            list.Items.Clear();

            ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT * FROM " + key);

            try
            {
                foreach (ManagementObject obj in searcher.Get()){
                    ListViewGroup listViewGroup;

                    try
                    {
                        listViewGroup = list.Groups.Add(obj["Name"].ToString(), obj["Name"].ToString());
                    }
                    catch (Exception ex){
                        listViewGroup = list.Groups.Add(obj.ToString(), obj.ToString());
                    }

                    if (obj.Properties.Count == 0)
                    {
                        MessageBox.Show("Не удалость получить информацию", "Ошибка", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }

                    foreach (PropertyData data in obj.Properties)
                    {
                        ListViewItem item = new ListViewItem(listViewGroup);


                        if (list.Items.Count % 2 != 0)
                        {
                            item.BackColor = Color.White;
                        }
                        else 
                        {
                            item.BackColor = Color.WhiteSmoke;
                        }

                        item.Text = data.Name;

                        if (data.Value != null && !string.IsNullOrEmpty(data.Value.ToString()))
                        {
                            switch (data.Value.GetType().ToString())
                            {
                                case "System.String[]":

                                    string[] stringData = data.Value as string[];

                                    string resStr1 = string.Empty;

                                    foreach (string s in stringData)
                                    {
                                        resStr1 += $"{s} ";
                                    }

                                    item.SubItems.Add(resStr1);


                                    break;

                                case "System.Unit16[]":

                                    ushort[] ushortData = data.Value as ushort[];

                                    string resStr2 = string.Empty;

                                    foreach(ushort u in ushortData)
                                    {
                                        resStr2 += $"{Convert.ToString(u)}";
                                    }

                                    item.SubItems.Add(resStr2);

                                    break;

                                default:

                                    item.SubItems.Add(data.Value.ToString());


                                    break;
                            }

                            list.Items.Add(item);



                        }



                    }



                }
            }
            catch (Exception ex)
            { 
                MessageBox.Show(ex.Message, "Ошибка", MessageBoxButtons.OK, MessageBoxIcon.Error); 
            }



        }





        private void toolStripComboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

            string key = string.Empty;

            switch (toolStripComboBox1.SelectedItem.ToString())
            {
                case "Процессор":

                    key = "Win32_Processor";

                    break;

                case "Видеокарта":

                    key = "Win32_VideoController";

                    break;

                case "Чипсет":

                    key = "Win32_IDEController";

                    break;

                case "Батарея":

                    key = "Win32_Battery";

                    break;

                case "Биос":

                    key = "Win32_BIOS";

                    break;

                case "Оперативная память":

                    key = "Win32_PhysicalMemory";

                    break;

                case "Кэш":

                    key = "Win32_CacheMemory";

                    break;

                case "USB":

                    key = "Win32_USBController";

                    break;

                case "Диск":

                    key = "Win32_DiskDrive";

                    break;

                case "Логические диски":

                    key = "Win32_LogicalDisk";

                    break;

                case "Клавиатура":

                    key = "Win32_Keyboard";

                    break;

                case "Сеть":

                    key = "Win32_NetworkAdapter";

                    break;

                case "Пользователи":

                    key = "Win32_Account";

                    break;

                default:

                    key = "Win32_Processor";

                    break;


            }

            GetInfo(key, listView1);



        }






        private void Form1_Load(object sender, EventArgs e)
        {
            toolStripComboBox1.SelectedIndex = 0;

        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Form2 newForm = new Form2();
            newForm.Show();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {

            Form3 newForm1 = new Form3();
            newForm1.Show();


        }
    }
}
