unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Vcl.DBCtrls, Vcl.Grids,
  Vcl.DBGrids, Data.Win.ADODB, Vcl.StdCtrls, Jpeg, Vcl.ExtCtrls, Vcl.ExtDlgs;

type
  TForm1 = class(TForm)
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    DBGrid1: TDBGrid;
    Button1: TButton;
    Image1: TImage;
    Button2: TButton;
    OpenDialog1: TOpenDialog;
    OpenPictureDialog1: TOpenPictureDialog;
    DBImage1: TDBImage;
    procedure Button1Click(Sender: TObject);
    procedure FormActivate(Sender: TObject);
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

uses Unit2;

procedure TForm1.Button1Click(Sender: TObject);
begin
    Form2.ShowModal;
end;

procedure TForm1.Button2Click(Sender: TObject);

var
   bs : TADOBlobStream;
begin
  if OpenPictureDialog1.Execute then begin
    Image1.Picture.Bitmap.LoadFromFile(OpenPictureDialog1.FileName);
    ADOQuery1.Edit;
     bs := TADOBlobStream.Create(TBlobField(ADOQuery1.FieldByName('Photo')), bmReadWrite);
     try
        Image1.Picture.Bitmap.SaveToStream(bs);
     finally
        bs.Free;
     end;
    ADOQuery1.Post;
     end;
end;

procedure TForm1.FormActivate(Sender: TObject);
var   MS:TMemorystream;

begin


 if (adoquery1.FieldByName('Photo') as tblobField).IsNull then exit;

 MS:=TMemorystream.Create;

 (adoquery1.FieldByName('Photo') as tblobField).SaveToStream(MS);
 MS.Position:=0;

image1.Picture:=nil; // Если не занулить будет ошибка
image1.Picture.bitmap.LoadFromStream(MS);


end;
end.
