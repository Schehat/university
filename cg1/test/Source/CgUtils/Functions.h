<<<<<<< HEAD
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <glm/glm.hpp>
#include <vector>
#include <string>

class Functions
{
public:
    static std::vector<glm::vec3> Lane_Riesenfeld_Unterteilungs_Algorithmus(std::vector<glm::vec3> vertices, int n);
    static int getId();
    static bool XOR(bool a, bool b);
    static std::string getPathtoObj(std::string obj);


private:
    static int unique_id;

};

#endif // FUNCTIONS_H
=======
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <glm/glm.hpp>
#include <vector>

class Functions
{
public:
    static std::vector<glm::vec3> Lane_Riesenfeld_Unterteilungs_Algorithmus(std::vector<glm::vec3> vertices, int n);
    static int getId();
    static bool XOR(bool a, bool b);


private:
    static int unique_id;

};

#endif // FUNCTIONS_H
>>>>>>> 2bba44709ff951a034d04fd1e87594f07d0ef76e
