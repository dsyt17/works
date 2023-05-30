object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 144
  ClientWidth = 387
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
    Left = 16
    Top = 17
    Width = 169
    Height = 89
    Lines.Strings = (
      'Memo1')
    TabOrder = 0
  end
  object Edit1: TEdit
    Left = 200
    Top = 17
    Width = 169
    Height = 89
    TabOrder = 1
    Text = 'Edit1'
  end
  object ComboBox1: TComboBox
    Left = 16
    Top = 112
    Width = 169
    Height = 21
    TabOrder = 2
    Text = #1074#1099#1073#1077#1088#1080#1090#1077' '#1094#1074#1077#1090' '#1092#1086#1085#1072
    OnChange = ComboBox1Change
    Items.Strings = (
      #1089#1080#1085#1080#1081
      #1082#1088#1072#1089#1085#1099#1081
      #1078#1077#1083#1090#1099#1081
      #1073#1077#1083#1099#1081
      #1079#1077#1083#1077#1085#1099#1081)
  end
  object ComboBox2: TComboBox
    Left = 200
    Top = 112
    Width = 169
    Height = 21
    TabOrder = 3
    Text = #1074#1099#1073#1077#1088#1080#1090#1077' '#1094#1074#1077#1090' '#1096#1088#1080#1092#1090#1072
    OnChange = ComboBox2Change
    Items.Strings = (
      #1089#1080#1085#1080#1081
      #1082#1088#1072#1089#1085#1099#1081
      #1078#1077#1083#1090#1099#1081
      #1073#1077#1083#1099#1081
      #1079#1077#1083#1077#1085#1099#1081)
  end
end
