# OPA-Demo
This is an application for demonstrate the power of OPA.
<br>
## Start Guide:
1. Download opa image from Docker Hub

2. Image name -> `openpolicyagent/opa:latest-istio-static`

3. Open cmd and run this command:
    ```bash
    docker run -d --name {container name} -p 8080:8181 \
    -v {path of your policies folder}:/{policies_id} \
    openpolicyagent/opa run --server --bundle /{policies_id}
    ```

4. To check that opa server is running successfully go to: `localhost:8080/v1/policies`
   This API must return a list of policies that you applied to OPA in step 3.
