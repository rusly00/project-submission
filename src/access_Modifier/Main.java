
package access_Modifier;

class person{
    private String name;
    public void setName(String newName)
    {
        name=newName;
    }
public String getName()
{
    return name;
}
}
public class Main{
    public static void main(String [] args){
        person p=new person();
        p.setName("elana");
        System.out.println(p.getName());
    }
}