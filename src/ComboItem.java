// Wrapper class for adding combo box items conveniently
class ComboItem
{
    private String key;
    private String value;

    ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getValue() { return value; }
}
