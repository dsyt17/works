object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 153
  ClientWidth = 228
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
    Width = 209
    Height = 89
    Lines.Strings = (
      'Memo1')
    TabOrder = 0
  end
  object RadioGroup1: TRadioGroup
    Left = 8
    Top = 103
    Width = 209
    Height = 42
    Caption = #1042#1099#1088#1086#1074#1085#1103#1090#1100' '#1090#1077#1082#1089#1090':'
    TabOrder = 1
  end
  object RadioButton1: TRadioButton
    Left = 16
    Top = 119
    Width = 58
    Height = 17
    Caption = #1085#1072' '#1083#1077#1074#1086
    TabOrder = 2
    OnClick = RadioButton1Click
  end
  object RadioButton2: TRadioButton
    Left = 80
    Top = 119
    Width = 73
    Height = 17
    Caption = #1087#1086' '#1094#1077#1085#1090#1088#1091
    TabOrder = 3
    OnClick = RadioButton2Click
  end
  object RadioButton3: TRadioButton
    Left = 154
    Top = 119
    Width = 66
    Height = 17
    Caption = #1085#1072' '#1087#1088#1072#1074#1086
    TabOrder = 4
    OnClick = RadioButton3Click
  end
end
