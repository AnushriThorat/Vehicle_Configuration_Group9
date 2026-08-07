namespace DotNetBackend.Services.Generic
{
    public interface IGenericService<TDto>
    {
        List<TDto> GetAll();

        TDto? GetById(int id);

        TDto Add(TDto dto);

        TDto Update(int id, TDto dto);

        void Delete(int id);
    }
}