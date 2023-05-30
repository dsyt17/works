unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    Memo1: TMemo;
    Edit1: TEdit;
    ComboBox1: TComboBox;
    ComboBox2: TComboBox;

    procedure ComboBox1Change(Sender: TObject);
    procedure ComboBox2Change(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}


procedure TForm1.ComboBox1Change(Sender: TObject);
begin
case ComboBox1.ItemIndex of
0:Form1.Color:=clBlue;
1:Form1.Color:=clRed;
2:Form1.Color:=clYellow;
3:Form1.Color:=clWhite;
4:Form1.Color:=clGreen;
end;
end;

procedure TForm1.ComboBox2Change(Sender: TObject);
begin
case ComboBox1.ItemIndex of
0:Form1.Font.Color:=clBlue;
1:Form1.Font.Color:=clRed;
2:Form1.Font.Color:=clYellow;
3:Form1.Font.Color:=clWhite;
4:Form1.Font.Color:=clGreen;
end;
end;


end.
