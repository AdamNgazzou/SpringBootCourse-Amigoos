
from transformers import pipeline
import sys

model_name = "TinyLlama/TinyLlama-1.1B-Chat-v1.0"
generator = pipeline('text-generation', model=model_name)

tech_stack = sys.argv[1]
name = sys.argv[2]

prompt = f"Based on the programming test stack {tech_stack} that {name} has given, provide a learning path"
response = generator(prompt, max_length=500)
print(response[0]['generated_text'])