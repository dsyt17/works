object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 721
  ClientWidth = 1284
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnActivate = FormActivate
  PixelsPerInch = 96
  TextHeight = 13
  object Image1: TImage
    Left = 496
    Top = 256
    Width = 105
    Height = 105
  end
  object DBGrid1: TDBGrid
    Left = 32
    Top = 48
    Width = 345
    Height = 120
    DataSource = DataSource1
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    Columns = <
      item
        Expanded = False
        FieldName = 'iDA'
        Width = 25
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'Photo'
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'Firm'
        Width = 50
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'StartYear'
        Width = 50
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'AName'
        Width = 50
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'Countru'
        Width = 50
        Visible = True
      end>
  end
  object Button1: TButton
    Left = 112
    Top = 520
    Width = 121
    Height = 25
    Caption = #1044#1086#1073#1072#1074#1080#1090#1100' '#1079#1072#1087#1080#1089#1100
    TabOrder = 1
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 344
    Top = 408
    Width = 75
    Height = 25
    Caption = 'Button2'
    TabOrder = 2
    OnClick = Button2Click
  end
  object DBImage1: TDBImage
    Left = 40
    Top = 200
    Width = 281
    Height = 297
    DataField = 'Photo'
    DataSource = DataSource1
    Stretch = True
    TabOrder = 3
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=Microsoft.Jet.OLEDB.4.0;Data Source=14.mdb;Persist Secu' +
      'rity Info=False'
    LoginPrompt = False
    Mode = cmShareDenyNone
    Provider = 'Microsoft.Jet.OLEDB.4.0'
    Left = 8
    Top = 680
  end
  object ADOQuery1: TADOQuery
    Active = True
    Connection = ADOConnection1
    CursorType = ctStatic
    Parameters = <>
    SQL.Strings = (
      'select * from auto')
    Left = 48
    Top = 680
  end
  object DataSource1: TDataSource
    DataSet = ADOQuery1
    Left = 88
    Top = 680
  end
  object OpenDialog1: TOpenDialog
    Left = 824
    Top = 264
  end
  object OpenPictureDialog1: TOpenPictureDialog
    Left = 552
    Top = 400
  end
end
