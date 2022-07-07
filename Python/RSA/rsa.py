# import sympy to generate random prime numbers
import sympy


def main():
    """Loop while getting user input"""    
    while True:
        option = int(input("1. Key Generation, 2. Encryption/Decryption, 3. quit => "))

        if option == 1:
            str = input("Enter two primes => ").split(" ")
            primes = [get_num(j) for j in str]
            keys = KeyGen(int(primes[0]), int(primes[1]))
            print("Private Key => ", "{", keys[0][0], ",", keys[0][1], "}")
            print("Public Key => ", "{", keys[1][0], ",", keys[1][1], "}")

        elif option == 2:
            inpt = input("Enter key and message => ")
            numbers = [get_num(s) for s in inpt.split(", ")]
            result = rsa(numbers[:2], numbers[2:])
            print(f"Result => {result}")
        
        elif option == 3:
            exit(0)


def KeyGen(p, q):
    """Key Generation"""
    keys = []
    n = p * q
    N = (p - 1) * (q - 1)
    e = sympy.randprime(3, N)
    d = pow(e, -1, N)

    keys.append((e, n))
    keys.append((d, n))
    return keys


def rsa(k, M):
    """RSA Encryption and Decrytion"""
    return [pow(x, k[0], k[1]) for x in M]


def get_num(x):
    """Extract numbers from string"""
    return int(''.join(ele for ele in x if ele.isdigit()))
             
if __name__ == '__main__':
    main()
