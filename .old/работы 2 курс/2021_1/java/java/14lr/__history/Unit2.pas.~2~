unit Unit2;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, db, Vcl.StdCtrls, Vcl.Buttons, Vcl.ExtCtrls, Jpeg;

type
  TForm2 = class(TForm)
    OpenDialog1: TOpenDialog;
    Image1: TImage;
    BitBtn1: TBitBtn;
    Edit1: TEdit;
    Edit2: TEdit;
    Edit3: TEdit;
    Edit4: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    BitBtn2: TBitBtn;
    procedure BitBtn1Click(Sender: TObject);
    procedure BitBtn2Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form2: TForm2;

implementation

{$R *.dfm}
uses Unit1;

procedure TForm2.BitBtn1Click(Sender: TObject);
begin
    if Opendialog1.execute then
    begin
      image1.picture.loadfromfile(opendialog1.filename);
    end;
end;

procedure TForm2.BitBtn2Click(Sender: TObject);
var
j: tjpegimage;
b: tbitmap;
begin
form1.adoquery1.insert;
form1.adoquery1['country']:=edit1.text;
form1.adoquery1['firm']:=edit2.text;
form1.adoquery1['AName']:=edit3.text;
form1.adoquery1['startYear']:=edit4.text;
if extractfileext(opendialog1.filename)='.bmp' then
TBlobField(form1.adoquery1.fieldbyname('Photo')).assign(image1.picture)
else
begin
  j:=tjpegimage.create;
  try
     j.compressionquality:=100;
     j.loadfromfile(opendialog1.filename);
     b:=tbitmap.create;
     try
      b.assign(j);
      tblobfield(form1.adoquery1.fieldbyname('Photo')).assign(b);
      finally
      b.free


     end;
             finally
             j.Free


  end;

end;
   form1.adoquery1.Post;
end;

end.
