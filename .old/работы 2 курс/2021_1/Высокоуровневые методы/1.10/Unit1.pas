unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    procedure Label1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
   k:integer;

implementation

{$R *.dfm}

procedure TForm1.Label1Click(Sender: TObject);
  begin

      k:=k+1;
      if k div 2 = 0 then
      Label1.Font.Color:=clRed
      else
      Label1.Font.Color:=clBlack

  end;


end.
