package sini.foxy.furscanner.Exception

import sini.foxy.furscanner.Modes


class IllegalModeException(mode : Modes, where : String) : FurScannerException(mode.toString(), where)