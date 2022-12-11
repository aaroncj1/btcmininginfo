FROM node:19.2-alpine3.15 as build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install

COPY . ./

RUN npm run build

RUN npm install -g serve
ENTRYPOINT [ "serve", "-s", "build" ]