Person Model Sample on java version 14 or later.

## About this package
Person model three programming patterns.

Person Model with sealed IF
- public String name
- public int age

Person Capsule Model with sealed IF
- private String name
- private int age
- public String getName()
- public void setName()
- public int getAge()
- public void setAge()

Person Record Model (implicit) with sealed IF
- private final String name
- private final int age
- public String name()
- public int age()

## Bind Checker
- name length is 2 to 15 characters.
- age is over 15.

## Update Rules
When updating, execute the following command.

```
mvn test
```

## License

This utility is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).