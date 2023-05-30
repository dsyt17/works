unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Vcl.Grids, Vcl.DBGrids,
  Data.Win.ADODB, Vcl.StdCtrls, Vcl.ComCtrls;

type
  TForm1 = class(TForm)
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    DBGrid1: TDBGrid;
    ComboBox1: TComboBox;
    Edit1: TEdit;
    ComboBox3: TComboBox;
    Label1: TLabel;
    Label3: TLabel;
    Button1: TButton;
    Button2: TButton;
    ADOQuery2: TADOQuery;
    DataSource2: TDataSource;
    Button3: TButton;
    Label4: TLabel;
    Button4: TButton;
    Button5: TButton;
    Edit2: TEdit;
    Label5: TLabel;

    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
    procedure Button4Click(Sender: TObject);
    procedure Button5Click(Sender: TObject);
    procedure DBGrid1CellClick(Column: TColumn);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);

begin
adoquery1.Close;
adoquery1.sql.Clear;
adoquery1.sql.Add('SELECT DISTINCTROW Family.FStatus, GoodTypes.GTName, Format$([Payments].[PDate],''yyyy'') AS [PDate по годам], Sum(Payments.Price) AS [Sum - Price]'+
'FROM (GoodTypes INNER JOIN Goods ON GoodTypes.[ID_GT] = Goods.[GType]) INNER JOIN (Family INNER JOIN Payments ON Family.[ID_S] = Payments.[Who]) ON Goods.[ID_G] = Payments.[Good]'+
'where GoodTypes.GTName=:nameg and Family.FStatus=:param1 GROUP BY Family.FStatus, GoodTypes.GTName, Format$([Payments].[PDate],''yyyy''), Year([Payments].[PDate]);');
adoquery1.parameters.ParamByName('param1').value:=combobox1.Text;
adoquery1.parameters.ParamByName('nameg').value:=combobox3.Text;
adoquery1.open;
{datetimepicker1.Date:=adoquery1.FieldByName('PDate по годам').AsDateTime;}
edit1.Text:=Vartostr(adoquery1.fieldbyname('Sum - price').value);
if edit1.Text='' then edit1.Text:='0';
end;



procedure TForm1.Button2Click(Sender: TObject);
begin
adoquery1.Close;
adoquery1.sql.Clear;
adoquery1.sql.Add('SELECT DISTINCTROW GoodTypes.GTName, Max(Payments.Price) AS [Max - Price]'+
                  'FROM (GoodTypes INNER JOIN Goods ON GoodTypes.[ID_GT] = Goods.[GType]) INNER JOIN Payments ON Goods.[ID_G] = Payments.[Good]'+
                  'where GoodTypes.GTName=:nameg GROUP BY GoodTypes.GTName;');
adoquery1.parameters.ParamByName('nameg').value:=combobox3.Text;
adoquery1.open;

adoquery2.Close;
adoquery2.sql.Clear;
adoquery2.sql.Add('SELECT Goods.GName, GoodTypes.GTName FROM GoodTypes INNER JOIN Goods ON GoodTypes.[ID_GT] = Goods.[GType] where GTName=:typeg;');
adoquery2.parameters.ParamByName('typeg').value:=adoquery1['GTName'];
adoquery2.open;
edit1.Text:=adoquery2.fieldbyname('GName').value;
end;

procedure TForm1.Button3Click(Sender: TObject);
begin
adoquery1.Close;
adoquery1.sql.Clear;
adoquery1.sql.Add('SELECT DISTINCTROW GoodTypes.GTName, Sum(Payments.Price) AS [Sum - Price]'+
                  'FROM (GoodTypes INNER JOIN Goods ON GoodTypes.[ID_GT] = Goods.[GType]) INNER JOIN Payments ON Goods.[ID_G] = Payments.[Good]'+
                  'where GoodTypes.GTName=:nameg GROUP BY GoodTypes.GTName;');
adoquery1.parameters.ParamByName('nameg').value:=combobox3.Text;
adoquery1.open;
edit1.Text:=adoquery1.fieldbyname('Sum - Price').value;

end;

procedure TForm1.Button4Click(Sender: TObject);
begin
adoquery1.Close;
adoquery1.sql.Clear;
adoquery1.sql.Add('SELECT DISTINCTROW Family.FStatus, Sum(Payments.Price) AS [Sum - Price]'+
                  'FROM Family INNER JOIN Payments ON Family.[ID_S] = Payments.[Who]'+
                  'where Family.FStatus=:param1 GROUP BY Family.FStatus;');
adoquery1.parameters.ParamByName('param1').value:=combobox1.Text;
adoquery1.open;
edit1.Text:=adoquery1.fieldbyname('Sum - Price').value;

end;

procedure TForm1.Button5Click(Sender: TObject);
var s:variant;
begin
adoquery1.Close;
adoquery1.sql.Clear;
adoquery1.sql.Add('SELECT DISTINCTROW Format$([Payments].[PDate],''mmmm yyyy'') AS [PDate по мес€цам], Avg(Payments.Price) AS [Avg - Price]'+
                  'FROM Payments GROUP BY Format$([Payments].[PDate],''mmmm yyyy''), Year([Payments].[PDate])*12+DatePart(''m'',[Payments].[PDate])-1;');
adoquery1.open;
s:=adoquery1.fieldbyname('Avg - Price').value;
s:=FormatFloat('0.##',s);
edit2.Text:=s/30;
end;

procedure TForm1.DBGrid1CellClick(Column: TColumn);
var s:variant;
begin
s:=adoquery1.fieldbyname('Avg - Price').value;
s:=FormatFloat('0.##',s);
edit2.Text:=s/30;
end;

end.
