#include "Functions.h"

std::vector<glm::vec3> Functions::Lane_Riesenfeld_Unterteilungs_Algorithmus(std::vector<glm::vec3> vertices, int n) {
    if(vertices.size() < 3) return vertices;

    int size = vertices.size();
    for (int i = 0; i < size; i++)
    {
        vertices.push_back( glm::vec3(0.0, 0.0, 0.0));
    }

    for (std::vector<unsigned int>::size_type i = 0; i < vertices.size(); i = i + 2 )
    {
        vertices.at(vertices.size()-i-1) = vertices.at(size-1-(i/2) );
        vertices.at(vertices.size()-i-2) = vertices.at(size-1-(i/2) );
    }

    //2-4 Schritte sind ueblich!
    for (int j = 0; j < n; j++)
    {
        for (std::vector<unsigned int>::size_type i = 0; i < vertices.size(); i++)
        {
            glm::vec3  newpoint= ( vertices.at(i) + vertices.at(i+1) );
            newpoint[0] = newpoint[0]/2;
            newpoint[1] = newpoint[1]/2;
            newpoint[2] = newpoint[2]/2;

            vertices.at(i) = newpoint;
        }
        vertices.erase(vertices.begin()+vertices.size()-1);
    }

    return vertices;
};
