unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.ComCtrls;

type
  TForm1 = class(TForm)
    RichEdit1: TRichEdit;
    Button1: TButton;
    Button2: TButton;
    procedure knopka(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}


procedure TForm1.knopka(Sender: TObject);
var
  f : TextFile;
  s : string;
begin
  s:=RichEdit1.text;
  AssignFile(f, 'myFile.txt');
  Rewrite(f);
         if ((Sender is TButton) and ((Sender as TButton).Name='Button1')) then
              writeln(f, s);

         if ((Sender is TButton) and ((Sender as TButton).Name='Button2')) then
              RichEdit1.Print('Имя документа');

  CloseFile(f);
 end;
end.
