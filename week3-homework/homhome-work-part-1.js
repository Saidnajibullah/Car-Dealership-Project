
// Question # 1
function fibonacci(num){
  let num1 = 0;
  let num2 = 1;
  let num3 = 1;
  for(i = 0; i < num; i++)
    {
      num3 = num1 + num2;
      num1 = num2;
      num2 = num3;
    }
    return num3;

}
// Question # 2

function bubbleSort(array){
  let len = array.length;
  for (let i = 0; i < len; i++) {
      for (let j = 0; j < len; j++) {
          if (array[j] > array[j + 1]) {
              let tmp = array[j];
              array[j] = array[j + 1];
              array[j + 1] = tmp;
          }
      }
      
  }
  return array
};

// Questtion # 3

function reverseString(str) {
  var splitString = str.split("");
  var reverseArray = splitString.reverse();
  var joinArray = reverseArray.join("");
  console.log(joinArray);
  //return joinArray; 
}

// Question # 4

function factorial(num){
  if(num > 0 && num <= 1){
    return 1;
  }
  else{
    return num * factorial(num - 1);
  }
}

//Question # 5
function subStr(str, len, offset){
  if(isNaN(str)){
      let substr = str.substring(offset, offset + len);
      return substr;
  }else{
    alert("The input was not a string!");
  }
}

// Question # 6
function evenNumber(num){
  if(num % 2 == 0){
    return true;
  }else{
    return false;
  }
}

//@uestion # 7

function palindrome(str){
    if(str.length == 1){
      return true;
    }else {
       for(i = 0; i <= str.length; i++){
         if(str.charAt(i) === str.charAt(str.length - 1)){
           return true;
         }else{
           return false;
         }
       }
    }
}

// Question # 8

function printShape(shape, height, char){
  switch(shape){
    case "Square":
      for(i = 0; i <= height; i++){
        for(j = 0; j <= height; j++){
          console.log(char);
        }
        console.log(" ");
      }
      break;
    case "Triangle":
        for(i = 0; i <= height; i++){
          for(j = height - i; j <= height; j++){
            console.log(char);
          }
          console.log(" ");
        }
      break;
      default: console.log("Wrong input");
      break;

  }
}

// Question # 9

function printObjectElements(obj){
  for (let key in obj) {
    if (obj.hasOwnProperty(key)) {
        console.log(key + ": "+ obj[key]);
    }
  }
}

// Question 10

function deleteArrayElement(array){
  console.log(array.length);
  array.slice(2, 3);
  console.log(array.length);
}

// Question # 11
function arraySplice(array){
  console.log(array.length);
  array.splice(2, 1);
  console.log(array.length);
}

//Question 12
function Person(name, age){
  this.name = name;
  this.age = age;
}
let Bob = new Person("Bob", 35);

// Question 13

function getPerson(name, age) {
    
  let Person = {};
  Person.name = name;
  Person.age = age;
  return Person;
}