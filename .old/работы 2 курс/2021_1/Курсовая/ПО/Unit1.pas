unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Data.Win.ADODB, Vcl.Grids,
  Vcl.DBGrids, Vcl.StdCtrls, Vcl.CheckLst, Vcl.ExtCtrls, Vcl.Imaging.jpeg;

type
  TForm1 = class(TForm)
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    Button4: TButton;
    Button6: TButton;
    Button1: TButton;
    Button2: TButton;
    Label1: TLabel;
    Image1: TImage;
    procedure Button4Click(Sender: TObject);
    procedure Button6Click(Sender: TObject);
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;


implementation

{$R *.dfm}

uses Unit3, Unit4;


procedure TForm1.Button1Click(Sender: TObject);
begin
Application.Terminate;

end;

procedure TForm1.Button2Click(Sender: TObject);
begin
showmessage('� ������ ��������� ����� ���� ������ ���������� ����� �������� ����� � �������, � ������� �������� ������������ ����� ������� ����� � ������ ��� ��������� �� ������ ����� ������������.'+#13#10+'�����: �������� �����.');
end;

procedure TForm1.Button4Click(Sender: TObject);
begin
Form3.ShowModal;
end;


procedure TForm1.Button6Click(Sender: TObject);
begin
Form4.ShowModal;
end;



end.
