package serialization.th87;

import java.io.Serializable;

// 1 如果对象的物理表示与其逻辑内容相同
class Name implements Serializable {
    private static final long serialVersionUID = 0L;
    /**
     * Last name. Must be non-null.
     *
     * @serial
     */
    private final String lastName;
    /**
     * First name. Must be non-null.
     *
     * @serial
     */
    private final String firstName;
    /**
     * Middle name, or null if there is none.
     *
     * @serial
     */
    private final String middleName;

    public Name() {
        firstName = "";
        middleName = "";
        lastName = "";
    }
}
