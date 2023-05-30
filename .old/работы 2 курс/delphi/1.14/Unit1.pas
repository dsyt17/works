unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    ListBox1: TListBox;
    Button1: TButton;
    Button2: TButton;
    Button3: TButton;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
    procedure FormActivate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  def: TStrings;
implementation

{$R *.dfm}

procedure TForm1.FormActivate(Sender: TObject);
begin
 def:=TStringList.Create;
 def.Assign(ListBox1.items);
end;

procedure TForm1.Button1Click(Sender: TObject);
begin
  var
   i, x: Integer;
       begin
       for i := 0 to (ListBox1.Items.Count - 1) do
           for x := 0 to (ListBox1.Items.Count - 1) do
             if (ListBox1.Items[x] < ListBox1.Items[i]) and (x > i) then
                 begin
                   ListBox1.Items.Insert(i, ListBox1.Items[x]);
                   ListBox1.Items.Delete(x + 1);
                 end;
end;
end;

procedure TForm1.Button2Click(Sender: TObject);
begin
   var
   i, x: Integer;
       begin
       for i := 0 to (ListBox1.Items.Count - 1) do
           for x := 0 to (ListBox1.Items.Count - 1) do
             if (ListBox1.Items[x] > ListBox1.Items[i]) and (x > i) then
                 begin
                   ListBox1.Items.Insert(i, ListBox1.Items[x]);
                   ListBox1.Items.Delete(x + 1);
                 end;
end;
end;

procedure TForm1.Button3Click(Sender: TObject);
begin
 ListBox1.Items.clear;
 ListBox1.Items.Add(0, TStrings)
end;



end.
