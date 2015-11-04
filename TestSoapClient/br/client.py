from suds.client import Client
namespace = "http://quadro.ws/"  
wsdl = "http://127.0.0.1:54321/quadro?wsdl"  
client = Client(wsdl)
print client
result = client.service.getDesenho()
print result
client.service.setRemetente("MAM")
client.service.setDesenho("<circle id=\"100\" cx=\"215\" cy=\"120\" r=\"100\" stroke=\"#FF0000\" stroke-width=\"10\" fill=\"#0000FF\" />")
print client.service.getDesenho()
print client.service.getRemetente()
#for x in range(0, 3):
#   print "We're on time %d" % (x)