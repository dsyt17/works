object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 436
  ClientWidth = 479
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 47
    Top = 195
    Width = 19
    Height = 13
    Caption = #1050#1090#1086
  end
  object Label3: TLabel
    Left = 8
    Top = 227
    Width = 57
    Height = 13
    Caption = #1058#1080#1087' '#1090#1086#1074#1072#1088#1072
  end
  object Label4: TLabel
    Left = 315
    Top = 195
    Width = 55
    Height = 13
    Caption = #1055#1086#1090#1088#1072#1095#1077#1085#1086
  end
  object Label5: TLabel
    Left = 282
    Top = 227
    Width = 88
    Height = 13
    Caption = #1042' '#1089#1088#1077#1076#1085#1077#1084' '#1074' '#1076#1077#1085#1100
  end
  object DBGrid1: TDBGrid
    Left = 8
    Top = 8
    Width = 465
    Height = 161
    DataSource = DataSource1
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    OnCellClick = DBGrid1CellClick
  end
  object ComboBox1: TComboBox
    Left = 80
    Top = 192
    Width = 105
    Height = 21
    TabOrder = 1
    Items.Strings = (
      #1086#1090#1077#1094
      #1084#1072#1090#1100
      #1089#1099#1085
      #1076#1086#1095#1100' 1'
      #1076#1086#1095#1100' 2')
  end
  object Edit1: TEdit
    Left = 376
    Top = 192
    Width = 97
    Height = 21
    TabOrder = 2
    Text = #1057#1091#1084#1084#1072
  end
  object ComboBox3: TComboBox
    Left = 80
    Top = 224
    Width = 105
    Height = 21
    TabOrder = 3
    Items.Strings = (
      #1050#1086#1084#1084#1091#1085#1072#1083#1082#1072
      #1055#1088#1086#1076#1091#1082#1090#1099
      #1044#1077#1083#1080#1082#1072#1090#1077#1089#1099
      #1056#1072#1079#1074#1083#1077#1095#1077#1085#1080#1103)
  end
  object Button1: TButton
    Left = 152
    Top = 286
    Width = 169
    Height = 23
    Caption = #1057#1091#1084#1084#1072' '#1085#1072' '#1090#1080#1087' '#1090#1086#1074#1072#1088#1072
    TabOrder = 4
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 152
    Top = 315
    Width = 169
    Height = 23
    Caption = #1057#1072#1084#1099#1081' '#1076#1086#1088#1086#1075#1086#1081' '#1090#1086#1074#1072#1088
    TabOrder = 5
    OnClick = Button2Click
  end
  object Button3: TButton
    Left = 152
    Top = 344
    Width = 169
    Height = 25
    Caption = #1053#1072' '#1082#1072#1078#1076#1091#1102' '#1080#1079' '#1075#1088#1091#1087#1087' '#1090#1086#1074#1072#1088#1086#1074
    TabOrder = 6
    OnClick = Button3Click
  end
  object Button4: TButton
    Left = 152
    Top = 375
    Width = 169
    Height = 25
    Caption = #1050#1090#1086' '#1089#1082#1086#1083#1100#1082#1086' '#1087#1086#1090#1088#1072#1090#1080#1083
    TabOrder = 7
    OnClick = Button4Click
  end
  object Button5: TButton
    Left = 152
    Top = 406
    Width = 169
    Height = 25
    Caption = #1042' '#1076#1077#1085#1100' '#1074' '#1089#1088#1077#1076#1085#1077#1084
    TabOrder = 8
    OnClick = Button5Click
  end
  object Edit2: TEdit
    Left = 376
    Top = 224
    Width = 97
    Height = 21
    MaxLength = 2
    TabOrder = 9
  end
  object ADOConnection1: TADOConnection
    Connected = True
    ConnectionString = 
      'Provider=Microsoft.Jet.OLEDB.4.0;Data Source=3.1.mdb;Persist Sec' +
      'urity Info=False'
    LoginPrompt = False
    Mode = cmShareDenyNone
    Provider = 'Microsoft.Jet.OLEDB.4.0'
    Left = 104
    Top = 440
  end
  object ADOQuery1: TADOQuery
    Connection = ADOConnection1
    Parameters = <>
    Left = 152
    Top = 440
  end
  object DataSource1: TDataSource
    DataSet = ADOQuery1
    Left = 200
    Top = 440
  end
  object ADOQuery2: TADOQuery
    Connection = ADOConnection1
    Parameters = <>
    Left = 256
    Top = 440
  end
  object DataSource2: TDataSource
    DataSet = ADOQuery2
    Left = 312
    Top = 440
  end
end
