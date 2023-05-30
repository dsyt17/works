unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Menus, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    Memo1: TMemo;
    Memo2: TMemo;
    PopupMenu1: TPopupMenu;
    PopupMenu2: TPopupMenu;
    N1: TMenuItem;
    N2: TMenuItem;
    N3: TMenuItem;
    N4: TMenuItem;
    N5: TMenuItem;
    N6: TMenuItem;
    N7: TMenuItem;
    procedure N4Click(Sender: TObject);
    procedure N5Click(Sender: TObject);
    procedure N2Click(Sender: TObject);
    procedure N3Click(Sender: TObject);
    procedure N7Click(Sender: TObject);
    procedure N6Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.N2Click(Sender: TObject);
  begin
  Memo1.PasteFromClipboard;
  end;

procedure TForm1.N3Click(Sender: TObject);
  begin
     Memo1.CutToClipboard;
  end;

procedure TForm1.N4Click(Sender: TObject);
  begin
     Memo1.SelectAll;
     Memo1.CopyToClipboard;
  end;

procedure TForm1.N5Click(Sender: TObject);
  begin
     Memo1.CopyToClipboard;
  end;

procedure TForm1.N6Click(Sender: TObject);
begin
    Memo2.Lines.Clear;
end;

procedure TForm1.N7Click(Sender: TObject);
  begin
      Form1.Close;
  end;

end.
