unit Unit4;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Data.Win.ADODB, Vcl.Grids,
  Vcl.DBGrids, Vcl.StdCtrls, Vcl.CheckLst, Vcl.ExtCtrls, jpeg, Dbctrls,
  Vcl.ComCtrls, Vcl.Buttons, Vcl.ExtDlgs;

type
  TForm4 = class(TForm)
    Button1: TButton;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    BitBtn1: TBitBtn;
    Image1: TImage;
    BitBtn2: TBitBtn;
    OpenDialog1: TOpenDialog;
    ADOQuery2: TADOQuery;
    DBGrid1: TDBGrid;
    procedure Button1Click(Sender: TObject);
    procedure DBGrid1TitleClick(Column: TColumn);
    procedure BitBtn1Click(Sender: TObject);
    procedure BitBtn2Click(Sender: TObject);
    procedure FormActivate(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form4: TForm4;

implementation

{$R *.dfm}

uses Unit3;

procedure TForm4.BitBtn1Click(Sender: TObject);
  begin
  if Opendialog1.execute then
      begin
        image1.picture.loadfromfile(opendialog1.filename);
      end;
  end;

procedure TForm4.BitBtn2Click(Sender: TObject);
var
j: tjpegimage;
b: tbitmap;
begin

adoquery2.edit;
if extractfileext(opendialog1.filename)='.bmp' then
TBlobField(adoquery2.fieldbyname('Фото')).assign(image1.picture)
else
begin
  j:=tjpegimage.create;
  try
     j.compressionquality:=100;
     j.loadfromfile(opendialog1.filename);
     b:=tbitmap.create;
     try
      b.assign(j);
      tblobfield(adoquery2.fieldbyname('Фото')).assign(b);
      finally
      b.free
     end;
      finally
     j.Free
  end;

end;
adoquery2.Post;
end;



procedure TForm4.Button1Click(Sender: TObject);
begin
form4.Close;
end;





procedure TForm4.DBGrid1TitleClick(Column: TColumn);
begin
 adoquery2.sort:=column.Field.Fieldname;
end;

procedure TForm4.FormActivate(Sender: TObject);
begin
      DBGrid1.Columns.Items[0].Width:=125;
      DBGrid1.Columns[0].Title.Caption:='Город';
      DBGrid1.Columns.Items[1].Visible:=False;
      DBGrid1.Columns[0].Title.Alignment:=tacenter;
      DBGrid1.Columns[0].Title.Font.Style:=[fsBold];

end;


end.
