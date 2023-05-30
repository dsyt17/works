object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 229
  ClientWidth = 586
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel
    Left = 8
    Top = 8
    Width = 297
    Height = 185
    TabOrder = 0
    object Label1: TLabel
      Left = 10
      Top = 16
      Width = 72
      Height = 13
      Caption = #1044#1072#1090#1072' '#1074#1099#1076#1072#1095#1080':'
    end
    object Label2: TLabel
      Left = 10
      Top = 48
      Width = 59
      Height = 13
      Caption = #1050#1077#1084' '#1074#1099#1076#1072#1085':'
    end
    object Label3: TLabel
      Left = 10
      Top = 72
      Width = 102
      Height = 13
      Caption = #1052#1077#1089#1090#1086' '#1088#1077#1075#1080#1089#1090#1088#1072#1094#1080#1080':'
    end
    object Edit4: TEdit
      Left = 96
      Top = 13
      Width = 185
      Height = 21
      TabOrder = 0
      Text = 'Edit4'
    end
    object Edit5: TEdit
      Left = 75
      Top = 45
      Width = 206
      Height = 21
      TabOrder = 1
      Text = 'Edit5'
    end
    object Memo1: TMemo
      Left = 10
      Top = 91
      Width = 271
      Height = 86
      Lines.Strings = (
        'Memo1')
      TabOrder = 2
    end
  end
  object Panel2: TPanel
    Left = 311
    Top = 8
    Width = 266
    Height = 185
    TabOrder = 1
    object Label4: TLabel
      Left = 16
      Top = 16
      Width = 72
      Height = 13
      Caption = #1044#1072#1090#1072' '#1074#1099#1076#1072#1095#1080':'
    end
    object Label5: TLabel
      Left = 16
      Top = 48
      Width = 59
      Height = 19
      Caption = #1050#1077#1084' '#1074#1099#1076#1072#1085':'
    end
    object Label6: TLabel
      Left = 16
      Top = 73
      Width = 93
      Height = 13
      Caption = #1044#1077#1081#1089#1090#1074#1080#1090#1077#1083#1077#1085' '#1076#1086':'
    end
    object Edit1: TEdit
      Left = 96
      Top = 16
      Width = 161
      Height = 21
      TabOrder = 0
      Text = 'Edit1'
    end
    object Edit2: TEdit
      Left = 81
      Top = 43
      Width = 176
      Height = 21
      TabOrder = 1
      Text = 'Edit2'
    end
    object Edit3: TEdit
      Left = 115
      Top = 70
      Width = 142
      Height = 21
      TabOrder = 2
      Text = 'Edit3'
    end
  end
  object CheckBox1: TCheckBox
    Left = 8
    Top = 204
    Width = 297
    Height = 17
    Caption = #1055#1086#1082#1072#1079#1099#1074#1072#1090#1100' '#1076#1072#1085#1085#1099#1077' '#1087#1086' '#1086#1073#1097#1077#1075#1088#1072#1078#1076#1072#1085#1089#1082#1086#1084#1091' '#1087#1072#1089#1089#1087#1086#1088#1090#1091
    Checked = True
    State = cbChecked
    TabOrder = 2
    OnClick = CheckBox1Click
  end
  object CheckBox2: TCheckBox
    Left = 311
    Top = 204
    Width = 266
    Height = 17
    Caption = #1055#1086#1082#1072#1079#1099#1074#1072#1090#1100' '#1076#1072#1085#1085#1099#1077' '#1087#1086' '#1079#1072#1075#1088#1072#1085#1080#1095#1085#1086#1084#1091' '#1087#1072#1089#1089#1087#1086#1088#1090#1091
    Checked = True
    State = cbChecked
    TabOrder = 3
    OnClick = CheckBox2Click
  end
end
