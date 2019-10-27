default:
	@echo "=============Building Local Service============="
	docker build -f Dockerfile -t ocsen-service .
	chmod +x ./build.sh
	./build.sh

build: default
	@echo "=============Build And Starting Service Locally============="
	docker-compose up -d
	chmod +x ./topic.sh
	./topic.sh

up:
	@echo "=============Starting Service Locally============="
	docker-compose up -d

logs:
	docker-compose logs -f

down:
	docker-compose down

clean: down
	@echo "=============Cleaning Up============="
	rm -f ocsen-service
	docker system prune -f
	docker volume prune -f
