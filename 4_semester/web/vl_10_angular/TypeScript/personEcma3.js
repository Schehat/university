//ECMA 3
function Person(name, age) {
    this.name = name;
    this.age = age;
}
Person.prototype.sayHello = function () {
    console.log("Hello " + this.name 
                 + " age:" + this.age);
};

var p = new Person("Daisy", 23);
p.sayHello();

