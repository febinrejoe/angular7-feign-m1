# simple-frontend

## Use Angular CLI

Verify node version > 8.11

```
node -v
```

Verify npm version > 6.0.0

```
npm -v
```
Create an app using the CLI

```
ng new angular7-frontend
```

At this point I made changes to the app, to access the backend services

Now I'm ready to run it:

```
cd angular7-frontend
ng serve
```

Lastly I build the app so its ready to deploy

```
ng build
```

Now the app is compiled and ready to deploy and it lives in dist/angular7-frontend so we can deploy it

From the root of the project, we can deploy the app (where the manifest.yml lives)

Verify I'm pointed to the right space
```
cf target
```

```
cf push
```