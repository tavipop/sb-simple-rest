curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://p5589.softvision.ro:8080/api/persons

curl -i -H "Accept: application/stream+json" -H "Content-Type: application/stream+json" -X GET http://p5589.softvision.ro:8080/api/persons

curl -d '{"id":1,"firstName":"Jhon","lastName":"Doe","age":20,"sex":true}' -H 'Content-Type: application/json' -X POST http://p5589.softvision.ro:8080/api/persons

curl -d '{"id":1,"firstName":"Jhon","lastName":"Doe","age":20,"sex":true}' -H "Content-Type: application/stream+json" -X POST http://p5589.softvision.ro:8080/api/persons

https://github.com/poutsma/web-function-sample

https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html


{"id":1450309750,"firstName":"PBfRIp5yNi","lastName":"8FG26T7atZ","age":360389228,"sex":true}

curl -d '{"id":1,"firstName":"Jhon","lastName":"Doe","age":20,"sex":true}' -H 'Content-Type: application/json' -X POST http://localhost:8080/api/persons/
