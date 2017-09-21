/**
 * Created by Dmitry on 18.09.2017.
 */
public class Person {

    private String sex;
    private String skill;

    public Person(String sex, String skill) {
        this.sex = sex;
        this.skill = skill;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSex() {

        return sex;
    }

    public String getSkill() {
        return skill;
    }
}
