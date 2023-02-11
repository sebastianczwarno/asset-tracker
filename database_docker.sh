docker stop asset-tracker-db || true && docker rm asset-tracker-db || true
docker run -p 41110:5432 --name asset-tracker-db -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=asset-tracker -d docker.io/library/postgres:10-alpine
