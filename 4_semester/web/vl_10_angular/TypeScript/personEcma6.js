//ECMA 6
class Person{
    constructor(name, age){
        this.name = name;
        this.age = age;
    }
    sayHello(){
        console.log("Hello " + this.name 
                     +  " age:" + this.age)
    }
}

var p = new Person("Daisy", 23);
p.sayHello();

