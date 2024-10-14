FROM node:14 AS stage1
WORKDIR /app
RUN npm install
COPY . .
RUN npm run build 

FROM nginx:alpine
COPY --from=stage1 /app/dist/your-angular-app /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
