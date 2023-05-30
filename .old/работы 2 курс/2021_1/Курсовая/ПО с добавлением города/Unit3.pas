unit Unit3;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Data.Win.ADODB, Vcl.Grids,
  Vcl.DBGrids, Vcl.StdCtrls, Vcl.CheckLst, Vcl.ExtCtrls, jpeg, Dbctrls,
  Vcl.ComCtrls;

type
  TForm3 = class(TForm)
    DBGrid1: TDBGrid;
    ADOQuery1: TADOQuery;
    ADOConnection1: TADOConnection;
    DataSource1: TDataSource;
    Button1: TButton;
    Button2: TButton;
    Panel2: TPanel;
    Panel3: TPanel;
    ComboBox1: TComboBox;
    CheckBox1: TCheckBox;
    CheckBox2: TCheckBox;
    CheckBox3: TCheckBox;
    CheckBox4: TCheckBox;
    CheckBox5: TCheckBox;
    CheckBox6: TCheckBox;
    CheckBox7: TCheckBox;
    CheckBox8: TCheckBox;
    CheckBox9: TCheckBox;
    CheckBox10: TCheckBox;
    CheckBox11: TCheckBox;
    CheckBox12: TCheckBox;
    CheckBox13: TCheckBox;
    CheckBox14: TCheckBox;
    CheckBox15: TCheckBox;
    CheckBox16: TCheckBox;
    CheckBox17: TCheckBox;
    CheckBox18: TCheckBox;
    CheckBox19: TCheckBox;
    CheckBox21: TCheckBox;
    CheckBox22: TCheckBox;
    CheckBox23: TCheckBox;
    CheckBox24: TCheckBox;
    CheckBox25: TCheckBox;
    CheckBox26: TCheckBox;
    CheckBox27: TCheckBox;
    CheckBox28: TCheckBox;
    CheckBox29: TCheckBox;
    CheckBox30: TCheckBox;
    CheckBox31: TCheckBox;
    CheckBox32: TCheckBox;
    CheckBox33: TCheckBox;
    CheckBox20: TCheckBox;
    DBImage1: TDBImage;
    DBMemo1: TDBMemo;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    ADOQuery2: TADOQuery;
    DataSource2: TDataSource;
    Button3: TButton;
    Button5: TButton;
    Button6: TButton;
    Image1: TImage;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button4Click(Sender: TObject);
    procedure Button5Click(Sender: TObject);
    procedure Button6Click(Sender: TObject);
    procedure DBGrid1TitleClick(Column: TColumn);
    procedure DBGrid1CellClick(Column: TColumn);
    procedure DBGrid1DrawColumnCell(Sender: TObject; const Rect: TRect;
      DataCol: Integer; Column: TColumn; State: TGridDrawState);
    procedure Button3Click(Sender: TObject);
    procedure FormShow(Sender: TObject);




  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form3: TForm3;

implementation

{$R *.dfm}

uses Unit1,
      Unit4;


procedure TForm3.Button1Click(Sender: TObject);
  begin
      adoquery1.Close;
      adoquery1.sql.Clear;
      adoquery1.sql.add('SELECT distinct �����.��������_������, ������.��������, �����.��������');
      adoquery1.sql.add('FROM (((�����_����� INNER JOIN ((������ INNER JOIN ������ ON ������.[idClimate] = ������.[������]) INNER JOIN (��������������_������ INNER JOIN ������_��������������'+' ON ��������������_������.[idN] = ������_��������������.[idN]) ON ������.[idCountry] = ������_��������������.[idCountry]) ON ');
      adoquery1.sql.add('�����_�����.[idPlace] = ������.[�����_�����]) INNER JOIN (������ INNER JOIN ���_����� ON ������.[idSeason] = ���_�����.[idSeason]) '+'ON ������.[idCountry] = ���_�����.[idCountry]) INNER JOIN (�������_������� INNER JOIN ����� ON �������_�������.[idSize] = �����.[������ ������]) ON ������.[idCountry] =');
      adoquery1.sql.add('�����.[������]) INNER JOIN (�������������� INNER JOIN ��������������_����� ON ��������������.[idR] = ��������������_�����.[idR]) ON �����.[idCity] = ��������������_�����.[idCity]');
      adoquery1.sql.add('where (�����_�����.�����_�����=:Place1 or �����_�����.�����_�����=:Place2 or �����_�����.�����_�����=:Place3 or �����_�����.�����_�����=:Place4 or �����_�����.�����_�����=:Place5)');
      adoquery1.sql.add('and (������.�����=:Season)');
      adoquery1.sql.add('and (���_�������=:Climate1 or ���_�������=:Climate2 or ���_�������=:Climate3 or ���_�������=:Climate4 or ���_�������=:Climate5 or ���_�������=:Climate6 or ���_�������=:Climate7 or ���_�������=:Climate8 or ���_�������=:Climate9)');
      adoquery1.sql.add('and (��������������_������.��������_��������������=:Napra1 or ��������������_������.��������_��������������=:Napra2 or ��������������_������.��������_��������������=:Napra3 or ��������������_������.��������_��������������=:Napra4)');
      adoquery1.sql.add('and (������.�������_��������=:Culture1 or ������.�������_��������=:Culture2)');
      adoquery1.sql.add('and (�������_�������.������=:Size1 or �������_�������.������=:Size2 or �������_�������.������=:Size3 or �������_�������.������=:Size4)');
      adoquery1.sql.add('and (��������_���=:Inf1 or ��������_���=:Inf2 or ��������_���=:Inf3 or ��������_���=:Inf4 or ��������_���=:Inf5 or ��������_���=:Inf6 or ��������_���=:Inf7 or ��������_���=:Inf8 or ��������_���=:Inf9)');
      {adoquery1.sql.add('group by ��������_������'); }
      if checkbox1.Checked=true then ADOQuery1.Parameters.ParamByName('Place1').Value:=checkbox1.caption else ADOQuery1.Parameters.ParamByName('Place1').Value:='';
      if checkbox2.Checked=true then ADOQuery1.Parameters.ParamByName('Place2').Value:=checkbox2.caption else ADOQuery1.Parameters.ParamByName('Place2').Value:='';
      if checkbox3.Checked=true then ADOQuery1.Parameters.ParamByName('Place3').Value:=checkbox3.caption else ADOQuery1.Parameters.ParamByName('Place3').Value:='';
      if checkbox4.Checked=true then ADOQuery1.Parameters.ParamByName('Place4').Value:=checkbox4.caption else ADOQuery1.Parameters.ParamByName('Place4').Value:='';
      if checkbox5.Checked=true then ADOQuery1.Parameters.ParamByName('Place5').Value:=checkbox5.caption else ADOQuery1.Parameters.ParamByName('Place5').Value:='';

      if ((checkbox1.Checked=false) and (checkbox2.Checked=false) and (checkbox3.Checked=false) and (checkbox4.Checked=false) and (checkbox5.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Place1').Value:=checkbox1.caption;
       ADOQuery1.Parameters.ParamByName('Place2').Value:=checkbox2.caption;
       ADOQuery1.Parameters.ParamByName('Place3').Value:=checkbox3.caption;
       ADOQuery1.Parameters.ParamByName('Place4').Value:=checkbox4.caption;
       ADOQuery1.Parameters.ParamByName('Place5').Value:=checkbox5.caption;
       end;



      if checkbox6.Checked=true then ADOQuery1.Parameters.ParamByName('Climate1').Value:=checkbox6.caption else ADOQuery1.Parameters.ParamByName('Climate1').Value:='';
      if checkbox7.Checked=true then ADOQuery1.Parameters.ParamByName('Climate2').Value:=checkbox7.caption else ADOQuery1.Parameters.ParamByName('Climate2').Value:='';
      if checkbox8.Checked=true then ADOQuery1.Parameters.ParamByName('Climate3').Value:=checkbox8.caption else ADOQuery1.Parameters.ParamByName('Climate3').Value:='';
      if checkbox9.Checked=true then ADOQuery1.Parameters.ParamByName('Climate4').Value:=checkbox9.caption else ADOQuery1.Parameters.ParamByName('Climate4').Value:='';
      if checkbox10.Checked=true then ADOQuery1.Parameters.ParamByName('Climate5').Value:=checkbox10.caption else ADOQuery1.Parameters.ParamByName('Climate5').Value:='';
      if checkbox11.Checked=true then ADOQuery1.Parameters.ParamByName('Climate6').Value:=checkbox11.caption else ADOQuery1.Parameters.ParamByName('Climate6').Value:='';
      if checkbox12.Checked=true then ADOQuery1.Parameters.ParamByName('Climate7').Value:=checkbox12.caption else ADOQuery1.Parameters.ParamByName('Climate7').Value:='';
      if checkbox13.Checked=true then ADOQuery1.Parameters.ParamByName('Climate8').Value:=checkbox13.caption else ADOQuery1.Parameters.ParamByName('Climate8').Value:='';
      if checkbox14.Checked=true then ADOQuery1.Parameters.ParamByName('Climate9').Value:=checkbox14.caption else ADOQuery1.Parameters.ParamByName('Climate9').Value:='';

       if ((checkbox6.Checked=false) and (checkbox7.Checked=false) and (checkbox8.Checked=false) and (checkbox9.Checked=false) and (checkbox10.Checked=false) and (checkbox11.Checked=false) and (checkbox12.Checked=false) and (checkbox13.Checked=false) and (checkbox14.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Climate1').Value:=checkbox6.caption;
       ADOQuery1.Parameters.ParamByName('Climate2').Value:=checkbox7.caption;
       ADOQuery1.Parameters.ParamByName('Climate3').Value:=checkbox8.caption;
       ADOQuery1.Parameters.ParamByName('Climate4').Value:=checkbox9.caption;
       ADOQuery1.Parameters.ParamByName('Climate5').Value:=checkbox10.caption;
       ADOQuery1.Parameters.ParamByName('Climate6').Value:=checkbox11.caption;
       ADOQuery1.Parameters.ParamByName('Climate7').Value:=checkbox12.caption;
       ADOQuery1.Parameters.ParamByName('Climate8').Value:=checkbox13.caption;
       ADOQuery1.Parameters.ParamByName('Climate9').Value:=checkbox14.caption;
       end;


      if checkbox15.Checked=true then ADOQuery1.Parameters.ParamByName('Napra1').Value:=checkbox15.caption else ADOQuery1.Parameters.ParamByName('Napra1').Value:='';
      if checkbox16.Checked=true then ADOQuery1.Parameters.ParamByName('Napra2').Value:=checkbox16.caption else ADOQuery1.Parameters.ParamByName('Napra2').Value:='';
      if checkbox17.Checked=true then ADOQuery1.Parameters.ParamByName('Napra3').Value:=checkbox17.caption else ADOQuery1.Parameters.ParamByName('Napra3').Value:='';
      if checkbox18.Checked=true then ADOQuery1.Parameters.ParamByName('Napra4').Value:=checkbox18.caption else ADOQuery1.Parameters.ParamByName('Napra4').Value:='';

      if ((checkbox15.Checked=false) and (checkbox16.Checked=false) and (checkbox17.Checked=false) and (checkbox18.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Napra1').Value:=checkbox15.caption;
       ADOQuery1.Parameters.ParamByName('Napra2').Value:=checkbox16.caption;
       ADOQuery1.Parameters.ParamByName('Napra3').Value:=checkbox17.caption;
       ADOQuery1.Parameters.ParamByName('Napra4').Value:=checkbox18.caption;
       end;


      if checkbox19.Checked=true then
      begin
      ADOQuery1.Parameters.ParamByName('Culture1').Value:='-1';
      ADOQuery1.Parameters.ParamByName('Culture2').Value:='0';
      end;
      if checkbox20.Checked=true then ADOQuery1.Parameters.ParamByName('Culture2').Value:='0';

      if ((checkbox19.Checked=false) and (checkbox20.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Culture1').Value:='-1';
       ADOQuery1.Parameters.ParamByName('Culture2').Value:='0';
       end;

      if checkbox21.Checked=true then ADOQuery1.Parameters.ParamByName('Size1').Value:=checkbox21.caption else ADOQuery1.Parameters.ParamByName('Size1').Value:='';
      if checkbox22.Checked=true then ADOQuery1.Parameters.ParamByName('Size2').Value:=checkbox22.caption else ADOQuery1.Parameters.ParamByName('Size2').Value:='';
      if checkbox23.Checked=true then ADOQuery1.Parameters.ParamByName('Size3').Value:=checkbox23.caption else ADOQuery1.Parameters.ParamByName('Size3').Value:='';
      if checkbox24.Checked=true then ADOQuery1.Parameters.ParamByName('Size4').Value:=checkbox24.caption else ADOQuery1.Parameters.ParamByName('Size4').Value:='';

      if ((checkbox21.Checked=false) and (checkbox22.Checked=false) and (checkbox23.Checked=false) and (checkbox24.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Size1').Value:=checkbox21.caption;
       ADOQuery1.Parameters.ParamByName('Size2').Value:=checkbox22.caption;
       ADOQuery1.Parameters.ParamByName('Size3').Value:=checkbox23.caption;
       ADOQuery1.Parameters.ParamByName('Size4').Value:=checkbox24.caption;
       end;


      if checkbox25.Checked=true then ADOQuery1.Parameters.ParamByName('Inf1').Value:=checkbox25.caption else ADOQuery1.Parameters.ParamByName('Inf1').Value:='';
      if checkbox26.Checked=true then ADOQuery1.Parameters.ParamByName('Inf2').Value:=checkbox26.caption else ADOQuery1.Parameters.ParamByName('Inf2').Value:='';
      if checkbox27.Checked=true then ADOQuery1.Parameters.ParamByName('Inf3').Value:=checkbox27.caption else ADOQuery1.Parameters.ParamByName('Inf3').Value:='';
      if checkbox28.Checked=true then ADOQuery1.Parameters.ParamByName('Inf4').Value:=checkbox28.caption else ADOQuery1.Parameters.ParamByName('Inf4').Value:='';
      if checkbox29.Checked=true then ADOQuery1.Parameters.ParamByName('Inf5').Value:=checkbox29.caption else ADOQuery1.Parameters.ParamByName('Inf5').Value:='';
      if checkbox30.Checked=true then ADOQuery1.Parameters.ParamByName('Inf6').Value:=checkbox30.caption else ADOQuery1.Parameters.ParamByName('Inf6').Value:='';
      if checkbox31.Checked=true then ADOQuery1.Parameters.ParamByName('Inf7').Value:=checkbox31.caption else ADOQuery1.Parameters.ParamByName('Inf7').Value:='';
      if checkbox32.Checked=true then ADOQuery1.Parameters.ParamByName('Inf8').Value:=checkbox32.caption else ADOQuery1.Parameters.ParamByName('Inf8').Value:='';
      if checkbox33.Checked=true then ADOQuery1.Parameters.ParamByName('Inf9').Value:=checkbox33.caption else ADOQuery1.Parameters.ParamByName('Inf9').Value:='';

       if ((checkbox25.Checked=false) and (checkbox26.Checked=false) and (checkbox27.Checked=false) and (checkbox28.Checked=false) and (checkbox29.Checked=false) and (checkbox30.Checked=false) and (checkbox31.Checked=false) and (checkbox32.Checked=false) and (checkbox33.Checked=false)) then
       begin
       ADOQuery1.Parameters.ParamByName('Inf1').Value:=checkbox25.caption;
       ADOQuery1.Parameters.ParamByName('Inf2').Value:=checkbox26.caption;
       ADOQuery1.Parameters.ParamByName('Inf3').Value:=checkbox27.caption;
       ADOQuery1.Parameters.ParamByName('Inf4').Value:=checkbox28.caption;
       ADOQuery1.Parameters.ParamByName('Inf5').Value:=checkbox29.caption;
       ADOQuery1.Parameters.ParamByName('Inf6').Value:=checkbox30.caption;
       ADOQuery1.Parameters.ParamByName('Inf7').Value:=checkbox31.caption;
       ADOQuery1.Parameters.ParamByName('Inf8').Value:=checkbox32.caption;
       ADOQuery1.Parameters.ParamByName('Inf9').Value:=checkbox33.caption;
       end;

      ADOQuery1.Parameters.ParamByName('Season').Value:=combobox1.Text;

      adoquery1.open;


      DBGrid1.Columns.Items[0].Width:=125;
      DBGrid1.Columns.Items[1].Width:=170;
      DBGrid1.Columns[0].Title.Caption:='�����';
      DBGrid1.Columns[1].Title.Caption:='������';
      DBGrid1.Columns.Items[2].Visible:=False;
      DBGrid1.Columns[0].Title.Alignment:=tacenter;
      DBGrid1.Columns[1].Title.Alignment:=tacenter;
      DBGrid1.Columns[0].Title.Font.Style:=[fsBold];
      DBGrid1.Columns[1].Title.Font.Style:=[fsBold];

      if (DBGrid1.DataSource.DataSet.IsEmpty) and (combobox1.text='�������� ���������� �����') then begin
      showmessage('�������� �����!');
      end;

      if (DBGrid1.DataSource.DataSet.IsEmpty) and NOT(combobox1.text='�������� ���������� �����') then begin
      showmessage('������ �� �������!'+#13#10+'�������� ��������� ������ � ��������� ������ ��� ���.');
      end;

  end;




procedure TForm3.Button2Click(Sender: TObject);
  begin
      form3.Close;
  end;



procedure TForm3.Button3Click(Sender: TObject);
begin
showmessage('������ �������� ������������� �������� �������� �� �������.'+' ������� �� �������� ������������� ��������������������� �������������� ������� ����������� � ������ �������. ��� ������������� ������� (����������� ��������, �����������, ���������, �����, ��������� �������� � ��.)'+
             '������������ ������� ��� ������� ����, ������� � �������� ���������,'+' ������ � ������������� ��������� ���������� �����, ����������� �� �������� � ������������, � ����������-������������� �������������� ������� ��� ���, �� ������� �������� ���������� ��������� � ������ �������� ��������� �������.');
end;

procedure TForm3.Button5Click(Sender: TObject);
begin
showmessage('������� �� ����������� ��������. ��������, ����, ������� � �����-���� ������ �������� �������, �� �� ������ ���� ��������� �������� �� �������� � ����������, �������� "���" � ������ ������.');
end;

procedure TForm3.Button6Click(Sender: TObject);
begin
showmessage('������	               ��������'+#13#10+
            '�����	                �� 20 ���. �������'+#13#10+
            '�������	             20 - 100 ���. �������'+#13#10+
            '�������	            100-500 ���. �������'+#13#10+
            '����������	     ����� 500 ���. �������');
end;

procedure TForm3.Button4Click(Sender: TObject);
begin
form4.showmodal;
end;

procedure TForm3.DBGrid1CellClick(Column: TColumn);
begin
adoquery2.Close;
adoquery2.sql.Text:='select * from ����� where (��������_������=:n);';
ADOQuery2.Parameters.ParamByName('n').value:=ADOQuery1['��������_������'];
adoquery2.open;
dbmemo1.DataField:='��������';
dbimage1.DataField:='����';
end;

procedure TForm3.DBGrid1DrawColumnCell(Sender: TObject; const Rect: TRect;
  DataCol: Integer; Column: TColumn; State: TGridDrawState);
begin
adoquery2.Close;
adoquery2.sql.Text:='select * from ����� where (��������_������=:n);';
ADOQuery2.Parameters.ParamByName('n').value:=ADOQuery1['��������_������'];
adoquery2.open;
dbmemo1.DataField:='��������';
dbimage1.DataField:='����';
end;


procedure TForm3.DBGrid1TitleClick(Column: TColumn);
begin
 adoquery1.sort:=column.Field.Fieldname;
end;

procedure TForm3.FormShow(Sender: TObject);
begin
showmessage('����� ���������� �� ����� ������ ������!'+#13#10+'�������� ���������� ��� ��������� �������� � ������� ������ "�������� ������".'+
            ' ���� ���� �� ������� ���������� �� ����� ��� ��� - �� ��������� � ��� ������.');
end;

end.
