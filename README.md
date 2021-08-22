Estudos microservices


1. Comunicação entre projetos usando Feign Client.
2. Balanceameno de carga com Ribbon
3. Descoberta de clientes com Eureka Server.
4. Hystrix para tolerância de falhas.
5. Spring cloud config server como servidor de configuração
6. Zuul como api gateway.


APIS : 

1. Workers ( API do retorno de trabalhadores).
2. Payroll (API do retorno de folha de pagamento).
3. Users ( API dos dados de autenticação do usuário).
4. Eureka (descoberta de clientes).
5. Config server (servidor de configuração).
6. Zuul (Api de gateway).



### Endpoints : 

GET : http://localhost:8001/workers
GET : http://localhost:8001/workers/1

GET : http://localhost:8101/payments/1/days/30 -- realiza chamadas na api workers.


Apos a implementação do eureka e api gateway 

GET : http://localhost:8765/hr-payroll/payments/2/days/1
GET : http://localhost:8765/hr-worker/workers
GET : http://localhost:8765/hr-worker/workers/configs -- teste para validar se o carregamento de configuração está correto.
GET : http://localhost:8765/hr-worker/actuator/refresh -- recarregar novas configurações.


Eureka Dashboard 

localhost:8761