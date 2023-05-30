unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    StaticText1: TStaticText;
    procedure StaticText1MouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  x0, x1: Integer;
move: Boolean;

implementation

{$R *.dfm}



procedure TForm1.StaticText1MouseDown(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
begin
const SC_DragMove = $F012;


  begin
      ReleaseCapture;
      StaticText1.perform(WM_SysCommand, SC_DragMove, 0);
  end;
end;

end.
