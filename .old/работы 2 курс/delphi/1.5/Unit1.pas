unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Menus;

type
  TForm1 = class(TForm)
    MainMenu1: TMainMenu;
    N1: TMenuItem;
    N2: TMenuItem;
    N3: TMenuItem;
    N4: TMenuItem;
    N5: TMenuItem;
    N6: TMenuItem;
    N7: TMenuItem;
    N8: TMenuItem;
    N9: TMenuItem;
    N10: TMenuItem;
    N11: TMenuItem;
    N12: TMenuItem;
    N13: TMenuItem;
    N14: TMenuItem;
    N15: TMenuItem;
    N16: TMenuItem;
    N17: TMenuItem;
    N18: TMenuItem;
    N19: TMenuItem;
    procedure N8Click(Sender: TObject);
    procedure N6Click(Sender: TObject);
    procedure N9Click(Sender: TObject);
    procedure N10Click(Sender: TObject);
    procedure N11Click(Sender: TObject);
    procedure N12Click(Sender: TObject);
    procedure N13Click(Sender: TObject);
    procedure N14Click(Sender: TObject);
    procedure N15Click(Sender: TObject);
    procedure N16Click(Sender: TObject);
    procedure N17Click(Sender: TObject);
    procedure N18Click(Sender: TObject);
    procedure N19Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.N10Click(Sender: TObject);
begin
ShowMessage('Это волк!')
end;

procedure TForm1.N11Click(Sender: TObject);
begin
ShowMessage('Это Воробей!')
end;

procedure TForm1.N12Click(Sender: TObject);
begin
    ShowMessage('Это варан!')
end;

procedure TForm1.N13Click(Sender: TObject);
begin
ShowMessage('Это курица!')
end;

procedure TForm1.N14Click(Sender: TObject);
begin
ShowMessage('Это осетр!')
end;

procedure TForm1.N15Click(Sender: TObject);
begin
ShowMessage('Это лосось!')
end;

procedure TForm1.N16Click(Sender: TObject);
begin
ShowMessage('Это карп!')
end;

procedure TForm1.N17Click(Sender: TObject);
begin
ShowMessage('Это угрь!')
end;

procedure TForm1.N18Click(Sender: TObject);
begin
ShowMessage('Это змея!')
end;

procedure TForm1.N19Click(Sender: TObject);
begin
ShowMessage('Это лягушка!')
end;

procedure TForm1.N6Click(Sender: TObject);
begin
ShowMessage('Это кошка!')
end;

procedure TForm1.N8Click(Sender: TObject);
begin
 ShowMessage('Это медведь!')
end;

procedure TForm1.N9Click(Sender: TObject);
begin
ShowMessage('Это шакал!')
end;

end.
