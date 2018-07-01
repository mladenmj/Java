package Banca;

import Banca.accountable.AccountableType;

public interface Accountable {
    double getImporto();
    AccountableType getType();
}