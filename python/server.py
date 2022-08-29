from flask import Flask, request, jsonify
from flask_restful import Resource, Api
from json import dumps
import jsonschema
from jsonschema import validate

app = Flask(__name__)
app.config['JSON_SORT_KEYS'] = False
api = Api(app)

clienteSchema = {
    "type": "object",
    "required": ["nome", "email"],
    "properties": {
        "nome": {"type": "string"},
        "email": {"type": "string"},
        "telefome": {"type": "number"}
    },
}

class Clientes(Resource):
    def post(self):
        try:
            print(validate(instance=request.json, schema=clienteSchema))
        except jsonschema.exceptions.ValidationError as err:
            msg = err.schema["error_msg"] if "error_msg" in err.schema else err.message
            msg_convert = msg.replace("is a required property", "e obrigatorio")
            return {"codigo":"validation_error", "erro": msg_convert},400

        req_nome = request.json['nome']
        print(req_nome)
        req_email = request.json['email']
        print(req_email)

        return jsonify(nome=req_nome, email=req_email)


api.add_resource(Clientes, '/clientes')

if __name__ == '__main__':
    app.run()
