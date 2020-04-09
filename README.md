# DDMall
## An online shopping mall system！                                --developed by destory_D team  

# Project overview            
DDmall system is a convenient system for online shopping. This system reproduces the existing litemal system. The reproduced system is developed by using object-oriented system development technology and means, which overcomes the shortcomings of the original system, such as low cohesion, high coupling, low operation efficiency and incomplete functions. Provide a safe, convenient and efficient e-mall system for businesses and customers.  

# DDMALL SYSTEM
This system is divided into 18 modules，jointly developed by several project development teams.
Modules include: Userinfo, freight,topic, discount,footprint, goods,cart,address,collect,payment,wxpayment,log,comment,logistics aftersale,ad,order,and share.  

## About this project
In the project of our development team, we developed the address module, freight module, comment module, share module, favorite module, footprint module and after-sales module of the mall system.  

## Technology
### This project is mainly based on the spring boot framework, and is developed with a variety of J2EE technologies.  
EUREKA: Eureka adopts the design framework of C-S. Eureka server is the server of service registration function, which is the service registry. Other microservices in the system use Eureka's client to connect to Eureka server and maintain heartbeat connection. In this way, the maintenance personnel of the system can use Eureka server to monitor the normal operation of various microservices in the system. 
In this project, we register the developed microservices on the Eureka registry, so that the calls between microservices can be realized.  
RIBBON: By abstracting other services into an interface with Feign annotation, calling other microservices is as simple as calling an interface in this project.  
ZUUL: Provide edge services such as load balancing, reverse proxy, authority authentication, dynamic routing, monitoring, flexibility, security, etc. In this project, zuul gateway is mainly used for authority authentication and routing.  
MAVEN: In this project, Maven is used to uniformly manage dependencies.  

## Design
![object model]https://github.com/yijunL/DDMall/blob/Division/Object%20model.png
![Module partition]https://github.com/yijunL/DDMall/blob/Division/1-2Modulepartition_1.Jpeg

