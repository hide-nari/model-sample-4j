Person Model Sample on java version 25 or later.

## About this package
Person model three programming patterns.

Person Model with sealed IF
- public String name
- public int age
- public GradeEnum grade

Person Capsule Model with sealed IF
- private String name
- private int age
- public String getName()
- public void setName()
- public int getAge()
- public void setAge()
- public GradeEnum getGrade()
- public void setGrade()

Person Record Model (implicit) with sealed IF
- private final String name
- private final int age
- public String name()
- public int age()

Grade Enum
- GOLD
- SILVER
- BRONZE
- upGrade()
- downGrade()

## Bind Checker
- Name length is 2 to 15 characters.
- Age is over 15.
- Grade in [ GOLD, SILVER, BRONZE ] not other value.

## Update Rules
When updating, execute the following command.

```
mvn test
```

## License

This utility is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).