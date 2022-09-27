// TypeScript - mit Datentypen!
class Person {
    name: string
    age: number
    constructor(name: string, age: number){
        this.name = name;
        this.age = age;
    }
    sayHello(){
        console.log("Hello " + this.name 
                     + " age:" + this.age);
    }
}

var p = new Person("Daisy", 23);
p.sayHello();


