unit Unit4;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Data.Win.ADODB, Vcl.Grids,
  Vcl.DBGrids, Vcl.StdCtrls, Vcl.CheckLst, Vcl.ExtCtrls, jpeg, Dbctrls,
  Vcl.ComCtrls, Vcl.Buttons, Vcl.ExtDlgs;

type
  TForm4 = class(TForm)
    Button1: TButton;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    BitBtn1: TBitBtn;
    Image1: TImage;
    OpenDialog1: TOpenDialog;
    ADOQuery2: TADOQuery;
    Edit1: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Memo1: TMemo;
    Label4: TLabel;
    ComboBox1: TComboBox;
    ComboBox2: TComboBox;
    CheckListBox1: TCheckListBox;
    Button2: TButton;
    ADOQuery3: TADOQuery;
    ADOQuery4: TADOQuery;
    ADOQuery5: TADOQuery;
    ADOQuery6: TADOQuery;
    ADOQuery7: TADOQuery;
    Label5: TLabel;
    Image2: TImage;
    procedure Button1Click(Sender: TObject);
    procedure DBGrid1TitleClick(Column: TColumn);
    procedure BitBtn1Click(Sender: TObject);
    procedure FormActivate(Sender: TObject);
    procedure SaveCityName(gname:string);
    procedure Button2Click(Sender: TObject);

  private
    { Private declarations }

  public

   Function GetIDCity(gname:string):integer;
   Function GetIDInfr(gname:string):integer;
   function CheckPresent(CLB: TCheckListBox): boolean;

  end;

var
  Form4: TForm4;

implementation

{$R *.dfm}

uses Unit3;

procedure TForm4.BitBtn1Click(Sender: TObject);
  begin
  if Opendialog1.execute then
      begin
        image1.picture.loadfromfile(opendialog1.filename);
      end;
  end;





procedure TForm4.Button1Click(Sender: TObject);
begin
form4.Close;
end;





procedure TForm4.Button2Click(Sender: TObject);
var i:integer;
begin
adoquery6.close;
adoquery6.open;
SaveCityName(edit1.text);
for i := 0 to checklistbox1.Items.Count-1 do
if checklistbox1.Checked[i] then
    begin
      adoquery5.open;
      adoquery5.Insert;
      adoquery5['idCity']:=GetIDCity(Edit1.text);
      adoquery5['idR']:=GetIDInfr(CheckListBox1.items[i]);
      adoquery5.post;
    end;

end;




procedure TForm4.DBGrid1TitleClick(Column: TColumn);
begin
 adoquery2.sort:=column.Field.Fieldname;
end;




procedure TForm4.FormActivate(Sender: TObject);
begin
ADOquery7.Open;

 with  ADOquery7 do
begin
ComboBox1.Items.clear;
DisableControls;
ComboBox1.Items.BeginUpdate;
First;
   while not Eof do
      begin
       ComboBox1.Items.Add(FieldByName('��������').AsString);
       Next;
      end;
ComboBox1.Items.EndUpdate;
EnableControls;
end;
end;

function TForm4.GetIDCity(gname: string): integer;
var aq:tadoquery;
begin
  aq:=tadoquery.Create(form4);
  aq.Connection:=form3.ADOConnection1;
  aq.SQL.Text:='select idCity from ����� where ��������_������=:n';
  aq.Parameters.ParamByName('n').Value:=gName;
  aq.Open;
  if aq.RecordCount>0 then result:=aq.Fields[0].AsInteger else result:=-1;
  aq.Free;
end;

function TForm4.GetIDInfr(gname: string): integer;
var aq:tadoquery;
begin
 aq:=tadoquery.Create(form4);
  aq.Connection:=form3.ADOConnection1;
  aq.SQL.Text:='select idR from �������������� where ��������_���=:n';
  aq.Parameters.ParamByName('n').Value:=gName;
  aq.Open;
  if aq.RecordCount>0 then result:=aq.Fields[0].AsInteger else result:=-1;
  aq.Free;
end;

function TForm4.CheckPresent(CLB: TCheckListBox): boolean;
var i: integer;
begin
  result := true;
  for i := 0 to CLB.Count - 1 do
    if CLB.Checked[i] then Exit;
  result := false;
end;


procedure TForm4.SaveCityName(gname:string);
var id:integer;
j: tjpegimage;
b: tbitmap;
aqt: tadoquery;
begin

              adoquery3.open;
              adoquery3.insert;

              if edit1.Text='������� ��������' then
              begin showmessage('������� �������� ������!');  exit;
              end;
              if combobox1.Text='�������� ������' then
              begin showmessage('�������� ������!');  exit;
              end;
              if combobox2.Text='�������� ������' then
              begin showmessage('�������� ������ ������!');  exit;
              end;
              if not CheckPresent(CheckListBox1) then
              begin ShowMessage('�������� ��������������!'); exit;
              end;
              {if memo1.Text='' then
              begin showmessage('��������� �������� ������!');  exit;
              end; }

              adoquery3['��������_������']:=edit1.Text;


              aqt:=tadoquery.Create(form4);
              aqt.Connection:=form3.ADOConnection1;
              aqt.SQL.Text:='select idCountry from ������ where ��������=:n';
              aqt.Parameters.ParamByName('n').value:=combobox1.Text;
              aqt.Open;
              adoquery3['������']:=aqt.FieldByName('idCountry').Value;
              aqt.Free;


              if combobox2.Text='�����' then adoquery3['������ ������']:='1';
              if combobox2.Text='�������' then adoquery3['������ ������']:='2';
              if combobox2.Text='�������' then adoquery3['������ ������']:='3';
              if combobox2.Text='����������' then adoquery3['������ ������']:='4';

              adoquery3['��������']:=memo1.text;

              id:=adoquery6.FieldByName('Expr1000').Value;
              id:=id+1;
              adoquery3['��������������']:=id;

                if extractfileext(opendialog1.filename)='.bmp' then
                TBlobField(adoquery3.fieldbyname('����')).assign(image1.picture)
                else
                    begin
                      j:=tjpegimage.create;
                      try
                         j.compressionquality:=100;
                         j.loadfromfile(opendialog1.filename);
                         b:=tbitmap.create;
                         try
                          b.assign(j);
                          tblobfield(adoquery3.fieldbyname('����')).assign(b);
                          finally
                          b.free
                         end;
                          finally
                         j.Free
                      end;

                        adoquery3.post;

                    end;

               ShowMessage('����� ��������!');

end;






end.
