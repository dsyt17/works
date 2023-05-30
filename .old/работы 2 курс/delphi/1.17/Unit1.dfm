object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 138
  ClientWidth = 206
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Memo1: TMemo
    Left = 8
    Top = 8
    Width = 185
    Height = 89
    Lines.Strings = (
      'Memo1')
    TabOrder = 0
  end
  object Button1: TButton
    Left = 8
    Top = 103
    Width = 89
    Height = 25
    Caption = #1062#1074#1077#1090' '#1090#1077#1082#1089#1090#1072
    TabOrder = 1
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 103
    Top = 103
    Width = 90
    Height = 25
    Caption = #1062#1074#1077#1090' '#1092#1086#1085#1072
    TabOrder = 2
    OnClick = Button2Click
  end
  object ColorDialog1: TColorDialog
    Left = 80
    Top = 40
  end
  object ColorDialog2: TColorDialog
    Left = 144
    Top = 40
  end
end
