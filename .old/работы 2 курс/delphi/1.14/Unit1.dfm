object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 125
  ClientWidth = 216
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
  object ListBox1: TListBox
    Left = 8
    Top = 8
    Width = 89
    Height = 105
    ItemHeight = 13
    Items.Strings = (
      #1055#1077#1090#1088#1086#1074
      #1041#1091#1096
      #1048#1075#1085#1072#1090#1086#1074
      #1057#1080#1076#1086#1088#1086#1074
      #1064#1086#1083#1086#1093#1086#1074
      #1043#1086#1084#1077#1083#1072#1091#1088#1080)
    TabOrder = 0
  end
  object Button1: TButton
    Left = 103
    Top = 8
    Width = 98
    Height = 25
    Caption = #1055#1086' '#1072#1083#1092#1072#1074#1080#1090#1091
    TabOrder = 1
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 103
    Top = 47
    Width = 98
    Height = 25
    Caption = #1055#1088#1086#1090#1080#1074' '#1072#1083#1092#1072#1074#1080#1090#1072
    TabOrder = 2
    OnClick = Button2Click
  end
  object Button3: TButton
    Left = 103
    Top = 88
    Width = 98
    Height = 25
    Caption = #1059#1084#1086#1083#1095#1072#1085#1080#1077
    TabOrder = 3
    OnClick = Button3Click
  end
end
