object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Popup'
  ClientHeight = 106
  ClientWidth = 395
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
    PopupMenu = PopupMenu1
    TabOrder = 0
  end
  object Memo2: TMemo
    Left = 199
    Top = 8
    Width = 185
    Height = 89
    Lines.Strings = (
      'Memo2')
    PopupMenu = PopupMenu2
    TabOrder = 1
  end
  object PopupMenu1: TPopupMenu
    Left = 96
    Top = 48
    object N1: TMenuItem
      Caption = #1050#1086#1087#1080#1088#1086#1074#1072#1090#1100
      object N4: TMenuItem
        Caption = #1074#1089#1077
        OnClick = N4Click
      end
      object N5: TMenuItem
        Caption = #1074#1099#1076#1077#1083#1077#1085#1085#1099#1081' '#1090#1077#1082#1089#1090
        OnClick = N5Click
      end
    end
    object N2: TMenuItem
      Caption = #1042#1089#1090#1072#1074#1080#1090#1100
      OnClick = N2Click
    end
    object N3: TMenuItem
      Caption = #1042#1099#1088#1077#1079#1072#1090#1100
      OnClick = N3Click
    end
  end
  object PopupMenu2: TPopupMenu
    Left = 264
    Top = 32
    object N6: TMenuItem
      Caption = #1054#1095#1080#1089#1090#1080#1090#1100' '#1086#1082#1085#1086
      OnClick = N6Click
    end
    object N7: TMenuItem
      Caption = #1042#1099#1081#1090#1080' '#1080#1079' '#1087#1088#1086#1075#1088#1072#1084#1084#1099
      OnClick = N7Click
    end
  end
end
