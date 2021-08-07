Estudos microservices


Comunicação entre projetos usando Feign Client.
Balanceameno de carga com Ribbon
Descoberta de clientes com Eureka Server.

APIS : 

1. Workers ( API do retorno de trabalhadores).
2. Payroll (API do retorno de folha de pagamento).



### Endpoints : 

GET : http://localhost:8001/workers
GET : http://localhost:8001/workers/1

GET : http://localhost:8101/payments/1/days/30 -- realiza chamadas na api workers.

