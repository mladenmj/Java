package Banca.accountable;

import Banca.Accountable;

public abstract class AbstractAccountable implements Accountable {

    public AccountableType Type;

    public AbstractAccountable(AccountableType type) {
        this.Type = type;
    }

    public AccountableType getType() {
        return Type;
    }
}
