resource "aws_ssm_parameter" "ssm_hello" {
  name  = "/config/demo-awspring-config-client/ssm.hello"
  type  = "String"
  value = "Hello from AWS SSM Parameter Store"
}

resource "aws_secretsmanager_secret" "asm_hello" {
  name = "/secret/demo-awspring-config-client"
}
resource "aws_secretsmanager_secret_version" "asm_hello" {
  secret_id = aws_secretsmanager_secret.asm_hello.id
  secret_string = jsonencode({
    "asm.hello" = "Hello from AWS Secrets Manager"
  })
}
